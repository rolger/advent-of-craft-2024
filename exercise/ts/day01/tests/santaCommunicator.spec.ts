import {SantaCommunicator} from "../src/santaCommunicator";
import {TestLogger} from "./doubles/testLogger";

const SantaCommunicatorSpec = 'Dasher';
const NORTH_POLE = 'North Pole';
const numberOfDaysToRest = 2;
const numberOfDayBeforeChristmas = 24;

const farAwayReindeerLocation = {
    reindeerName: SantaCommunicatorSpec,
    currentLocation: NORTH_POLE,
    numbersOfDaysForComingBack: 24
};

const nearByReindeerLocation = {
    reindeerName: SantaCommunicatorSpec,
    currentLocation: NORTH_POLE,
    numbersOfDaysForComingBack: 5
};

describe('SantaCommunicator', () => {
    let communicator: SantaCommunicator;
    let logger: TestLogger;

    beforeEach(() => {
        communicator = new SantaCommunicator(numberOfDaysToRest);
        logger = new TestLogger();
    });

    test('composeMessage', () => {
        const message = communicator.composeMessage(nearByReindeerLocation, numberOfDayBeforeChristmas);
        expect(message).toEqual('Dear Dasher, please return from North Pole in 17 day(s) to be ready and rest before Christmas.');
    });

    test('shouldDetectOverdueReindeer', () => {
        const overdue = communicator.isOverdue(farAwayReindeerLocation, numberOfDayBeforeChristmas, logger);

        expect(overdue).toBeTruthy();
        expect(logger.getLog()).toEqual('Overdue for Dasher located North Pole.');
    });

    test('shouldReturnFalseWhenNoOverdue', () => {
        const overdue = communicator.isOverdue(nearByReindeerLocation, numberOfDayBeforeChristmas, logger);
        expect(overdue).toBeFalsy();
    });
});