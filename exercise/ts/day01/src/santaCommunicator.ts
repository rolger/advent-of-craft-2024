import {Logger} from "./logger";

export interface ReindeerLocation {
    reindeerName: string;
    currentLocation: string;
    numbersOfDaysForComingBack: number;
}

export class SantaCommunicator {
    private readonly numberOfDaysToRest: number;

    constructor(numberOfDaysToRest: number) {
        this.numberOfDaysToRest = numberOfDaysToRest;
    }

    public composeMessage(reindeerLocation: ReindeerLocation, numberOfDaysBeforeChristmas: number): string {
        const daysBeforeReturn = this.daysBeforeReturn(reindeerLocation.numbersOfDaysForComingBack, numberOfDaysBeforeChristmas);
        return `Dear ${(reindeerLocation.reindeerName)}, please return from ${(reindeerLocation.currentLocation)} in ${daysBeforeReturn} day(s) to be ready and rest before Christmas.`;
    }

    public isOverdue(reindeerLocation: ReindeerLocation, numberOfDaysBeforeChristmas: number, logger: Logger): boolean {
        if (this.daysBeforeReturn(reindeerLocation.numbersOfDaysForComingBack, numberOfDaysBeforeChristmas) <= 0) {
            logger.log(`Overdue for ${reindeerLocation.reindeerName} located ${reindeerLocation.currentLocation}.`);
            return true;
        }
        return false;
    }

    private daysBeforeReturn(numbersOfDaysForComingBack: number, numberOfDaysBeforeChristmas: number): number {
        return (numberOfDaysBeforeChristmas - numbersOfDaysForComingBack - this.numberOfDaysToRest);
    }
}
