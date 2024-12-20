package travel;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class CalculatorBenchmark {
    @Param({"1", "10", "50"})
    public int numberOfReindeer;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(CalculatorBenchmark.class.getSimpleName())
                .warmupTime(TimeValue.seconds(1))
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 5, time = 1)
    @Measurement(iterations = 10, time = 1)
    public void calculateRecursive() {
        SantaTravelCalculator.calculateTotalDistanceRecursively(this.numberOfReindeer);
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 5, time = 1)
    @Measurement(iterations = 10, time = 1)
    public void calculateLoop() {
        SantaTravelCalculator.calculateTotalDistance(this.numberOfReindeer);
    }

    @Benchmark
    @Fork(1)
    @Warmup(iterations = 5, time = 1)
    @Measurement(iterations = 10, time = 1)
    public void calculateLoopWithBitOps() {
        SantaTravelCalculator.calculateTotalDistanceWithBitOps(this.numberOfReindeer);
    }

}
