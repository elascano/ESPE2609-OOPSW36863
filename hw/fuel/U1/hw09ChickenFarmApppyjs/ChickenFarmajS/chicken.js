class Chicken {
    constructor(id, name, color, bornOnDate, molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate; // Formato "YYYY-MM-DD"
        this.molting = molting;
        this.ageInYears = this.computeAgeInYears();
    }

    computeAgeInYears() {
        if (!this.bornOnDate) return 0;
        const birthDate = new Date(this.bornOnDate);
        const today = new Date();
        let age = today.getFullYear() - birthDate.getFullYear();
        const m = today.getMonth() - birthDate.getMonth();
        if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
            age--;
        }
        return Math.max(0, age);
    }
}

module.exports = Chicken;