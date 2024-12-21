<?php

use Tour\Step;
use Tour\TourCalculator;

it('calculates delivery time for some steps', function () {
    $steps = [
        new Step('08:00', 'Start', 0),
        new Step('09:00', 'Location B', 1800),
        new Step('08:30', 'Location A', 1800),
    ];
    
    $calculator = new TourCalculator($steps);
    $result1 = $calculator->calculate();
    $result2 = $calculator->calculate();
    
    expect($result1 . $result2)->toMatchSnapshot();
});

