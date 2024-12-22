<?php

namespace Tour;

class TourCalculator
{
    private $steps;
    private $deliveryTime = 0;
    private $calculated = false;

    public function __construct($steps)
    {
        $this->steps = $steps;

        usort($this->steps, function ($a, $b) {
            return $a->time <=> $b->time;
        });
    }

    public function isCalculated()
    {
        return $this->calculated;
    }

    public function getDeliveryTime()
    {
        return $this->deliveryTime;
    }

    public function calculate()
    {
        if (empty($this->steps)) {
            return "No locations !!!";
        }

        if (!$this->calculated) {
            foreach ($this->steps as $step) {
                $this->deliveryTime += $step->deliveryTime;
            }
        }

        $result = $this->format($this->steps, $this->deliveryTime);
        
        $this->calculated = true;
 
        return $result;
    }

    private function format($steps, $deliveryTime)
    {
        $result = '';
        foreach ($steps as $step) {
            $result .= $this->formatLine($step) . PHP_EOL;
        }
        $result .= $this->formatDeliveryTime($deliveryTime) . PHP_EOL;
        return $result;
    }

    private function formatLine($step)
    {
        if ($step === null) {
            throw new \InvalidArgumentException();
        } else {
            return "{$step->time} : {$step->label} | {$step->deliveryTime} sec";
        }
    }

    private function formatDeliveryTime($deliveryTime)
    {
        $hhMmSs = gmdate("H:i:s", $deliveryTime);
        return "Delivery time | {$hhMmSs}";
    }
}

$steps = [
    new Step('08:00', 'Start', 0),
    new Step('08:30', 'Location A', 1800),
    new Step('09:00', 'Location B', 1800),
];

$calculator = new TourCalculator($steps);
$result = $calculator->calculate();

if (strpos($result, 'No locations') !== false) {
    echo "Error: {$result}\n";
} else {
    echo $result;
}

?>