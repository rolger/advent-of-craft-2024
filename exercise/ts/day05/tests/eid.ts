enum ElfSex {
    Sloubi = 1,
    Gagna = 2,
    Catact = 3
};

const VALID_LENGTH = 8;

function validateLength(EID: string) {
    return EID.length === VALID_LENGTH;
}

function validateSex(EID: string) {
    let sex = EID.substring(0, 1);
    return sex in ElfSex;
}

function validateYear(EID: string) {
    let year = EID.substring(1, 3);
    return !isNaN(Number(year));
}

function validateSerialNumber(EID: string) {
    let serialNumber = EID.substring(3, 6);
    return !isNaN(Number(serialNumber));
}


function validateKey(EID: string) {
    let eidNumber = Number(EID.substring(0, 6));
    let key = Number(EID.substring(6));

    if (isNaN(eidNumber) || isNaN(key))
        return false;

    let keyComputed = 97 - eidNumber % 97;

    return key === keyComputed;
}

export function validateEID(EID: string) {
    return EID
        && validateLength(EID)
        && validateSex(EID)
        && validateYear(EID)
        && validateSerialNumber(EID)
        && validateKey(EID);
}
