
function validateEID(EID: string) {
    if (EID === null) {
        return false;
    }
    return true;
}

describe('EID Tester', () => {
    test('valid EIDs', () => {
        expect(validateEID('19800767')).toBeTruthy();
    });

    test('wrong input is an invalid EID', () => {
        expect(validateEID(null)).toBeFalsy();
    });

});