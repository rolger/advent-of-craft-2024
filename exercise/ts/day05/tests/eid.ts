enum ElfSex {
    Sloubi = 1,
    Gagna = 2,
    Catact = 3
};

const VALID_LENGTH = 8;

function validateLength(inputEID: string) {
    return inputEID.length === VALID_LENGTH;
}

function validateSex(inputEID: string) {
    let sex = inputEID.substring(0, 1);
    return sex in ElfSex;
}

function isANumber(number: string) {
    return !isNaN(Number(number));
}

function validateYear(inputEID: string) {
    return isANumber(inputEID.substring(1, 3));
}

function validateSerialNumber(inputEID: string) {
    return isANumber(inputEID.substring(3, 6));
}

function computedKey(eidNumber: number) {
    return 97 - eidNumber % 97;
}

function validateKey(EID: string) {
    let eidNumber = Number(EID.substring(0, 6));
    let key = Number(EID.substring(6));

    if (isNaN(eidNumber) || isNaN(key))
        return false;

    return key === computedKey(eidNumber);
}

export function validateEID(inputEID: string) {
    return inputEID
        && validateLength(inputEID)
        && validateSex(inputEID)
        && validateYear(inputEID)
        && validateSerialNumber(inputEID)
        && validateKey(inputEID);
}
