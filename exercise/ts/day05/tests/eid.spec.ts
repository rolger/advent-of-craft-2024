
function validateEID(EID: string) {
    if (!EID) {
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

});