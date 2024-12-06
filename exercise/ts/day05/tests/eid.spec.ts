
function validateEID(EID: string) {
    return true;
}

describe('EID', () => {
    test('implement your tests here', () => {
        expect(validateEID('19800767')).toBeTruthy();
    });
});