
function validateEID(EID: string) {
    if (!EID) {
        return false;
    }

    if (EID.length !== 8) {
        return false;
    }

    return true;
}

describe('EID Tester', () => {
    test('valid EIDs', () => {
        expect(validateEID('19800767')).toBeTruthy();
    });

    test('empty input is an invalid EID', () => {
        expect(validateEID(null)).toBeFalsy();
        expect(validateEID('')).toBeFalsy();
    });

    test('wrong length are invalid EIDs', () => {
        expect(validateEID('12')).toBeFalsy();
    });

});