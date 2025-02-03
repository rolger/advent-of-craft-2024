<?php

namespace Tour;

use Tour\Step;
use Tour\TourLinePrinter;

class TourCalculator
{
    private $tourPrinter;
    private $steps;
    private $deliveryTime = 0;
    private $calculated = false;

    public function __construct($steps, $tourPrinter)
    {
        $this->tourPrinter = $tourPrinter;
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

        $result = $this->tourPrinter->print($this->steps, $this->deliveryTime);
        
        $this->calculated = true;
 
        return $result;
    }

}

$steps = [
    new Step('08:00', 'Start', 0),
    new Step('08:30', 'Location A', 1800),
    new Step('09:00', 'Location B', 1800),
];

$calculator = new TourCalculator($steps, new TourLinePrinter());
$result = $calculator->calculate();

if (strpos($result, 'No locations') !== false) {
    echo "Error: {$result}\n";
} else {
    echo $result;
}

?>