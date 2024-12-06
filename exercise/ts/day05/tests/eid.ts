
enum ElfSex {
    Sloubi = 1,
    Gagna = 2,
    Catact = 3
};

export function validateEID(EID: string) {
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

    let serialNumber = EID.substring(3, 6);
    if (isNaN(Number(serialNumber)))
        return false;

    return true;
}
