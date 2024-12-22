<?php

namespace Tour;

use Tour\TourPrinter;

class TourLinePrinter implements TourPrinter
{
    public function print($steps, $deliveryTime)
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
