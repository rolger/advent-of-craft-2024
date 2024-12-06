
enum ElfSex {
    Sloubi = 1,
    Gagna = 2,
    Catact = 3
};

function validateEID(EID: string) {
    if (!EID) {
        return false;
    }

    const VALID_LENGTH = 8;
    if (EID.length !== VALID_LENGTH) {
        return false;
    }

    let sex = EID.substring(0, 1);
    if (!(sex in ElfSex))
        return false;

    let year = EID.substring(1, 3);
    if (isNaN(Number(year)))
        return false;

    return true;
}

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



});