import {validateEID} from "./eid";

describe('EID', () => {
    test('with valid values', () => {
        expect(validateEID('19800767')).toBeTruthy();
    });

    test('with empty input is invalid', () => {
        expect(validateEID(null)).toBeFalsy();
        expect(validateEID('')).toBeFalsy();
    });

    test('with wrong length are invalid', () => {
        expect(validateEID('12')).toBeFalsy();
    });

    test('with incorrect sex are invalid', () => {
        expect(validateEID('49800867')).toBeFalsy();
        expect(validateEID('09800867')).toBeFalsy();
        expect(validateEID('x9800867')).toBeFalsy();
    });

    test('with incorrect year are invalid', () => {
        expect(validateEID('21b00867')).toBeFalsy();
    });

    test('with incorrect serial number are invalid', () => {
        expect(validateEID('19800i67')).toBeFalsy();
    });

});