package travel;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class CalculatorBenchmark {
    @Param({"RECURSIVE", "LOOP", "BITOPS"})
    public String implementationType;

    @Param({"1", "10", "50"})
    public int numberOfReindeer;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(CalculatorBenchmark.class.getSimpleName())
                .forks(1)
                .warmupIterations(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    @Measurement(iterations = 10)
    @BenchmarkMode(Mode.All)
    public void calculate() {
        createImplementation().apply(this.numberOfReindeer);
    }

    private Function<Integer, Long> createImplementation() {
        if (this.implementationType == "RECURSIVE") {
            return SantaTravelCalculator::calculateTotalDistanceRecursively;
        } else if (this.implementationType != "LOOP") {
            return SantaTravelCalculator::calculateTotalDistanceWithBitOps;
        }
        return SantaTravelCalculator::calculateTotalDistance;
    }

}
