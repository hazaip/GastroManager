package hu.hubasky.gastromanager.entity.alapanyag;

/**
 * Alapanyag jellemzőket leíró osztály.
 * Created by mirso on 2017. 04. 26..
 */

public final class AlapanyagJellemzok {
    /**
     * A jellemző hány gramm tömegű anyagra vonatkozik.
     */
    private double vonatkoztatasGramm;
    /**
     * A fehérje tartolom %-ban.
     */
    private double feherjeSzazalek;
    /**
     * A zsírtartalom %-ban.
     */
    private double zsirSzazalek;
    /**
     * A szénhidrát tartalom %-ban.
     */
    private double szenhidratSzazalek;
    /**
     * Az energiatartalom KJ-ban.
     */
    private double energiaKJ;

    /**
     * Konstruktor.
     *
     * @param vonatkoztatasGramm hány gramm alapanyagra vonatkoznak a jellemzők.
     * @param feherjeSzazalek    a fehérje %-ban.
     * @param zsirSzazalek       a zsír %-ban.
     * @param szenhidratSzazalek a szénhidrát %-ban.
     * @param energiaKJ          az energia KJ-ban.
     */
    public AlapanyagJellemzok(double vonatkoztatasGramm, double feherjeSzazalek, double zsirSzazalek, double szenhidratSzazalek, double energiaKJ) {
        this.setVonatkoztatasGramm(vonatkoztatasGramm);
        this.setFeherjeSzazalek(feherjeSzazalek);
        this.setZsirSzazalek(zsirSzazalek);
        this.setSzenhidratSzazalek(szenhidratSzazalek);
        this.setEnergiaKJ(energiaKJ);
        checkSzazalek();
    }

    /**
     * Ellenőrzi a %-os értékeket.
     */
    private void checkSzazalek() {
        if (feherjeSzazalek + zsirSzazalek + szenhidratSzazalek > 1.0) {
            throw new IllegalStateException(String.format("A fehérje (%1$.2f)%% + zsír (%2$.2f)%% + szénhidrát (%3$.2f)%% > 100%%"
                    , feherjeSzazalek * 100, zsirSzazalek * 100, szenhidratSzazalek * 100));
        }
    }


    /**
     * A jellemző hány gramm tömegű anyagra vonatkozik.
     *
     * @return tömeg.
     */
    public double getVonatkoztatasGramm() {
        return vonatkoztatasGramm;
    }

    /**
     * A jellemző hány gramm tömegű anyagra vonatkozik.
     *
     * @param vonatkoztatasGramm a tömeg.
     */
    public void setVonatkoztatasGramm(double vonatkoztatasGramm) {
        if (Double.isNaN(vonatkoztatasGramm) || Double.isInfinite(vonatkoztatasGramm))
            throw new IllegalArgumentException();
        if (vonatkoztatasGramm <= 0) {
            throw new IllegalArgumentException("vonatkoztatasGramm <= 0");
        }
        this.vonatkoztatasGramm = vonatkoztatasGramm;
    }

    /**
     * A fehérje tartolom %-ban.
     *
     * @return százalék.
     */
    public double getFeherjeSzazalek() {
        return feherjeSzazalek;
    }

    /**
     * A fehérje tartolom %-ban.
     *
     * @param feherjeSzazalek százalék.
     */
    public void setFeherjeSzazalek(double feherjeSzazalek) {
        if (Double.isNaN(feherjeSzazalek) || Double.isInfinite(feherjeSzazalek))
            throw new IllegalArgumentException();

        if (feherjeSzazalek < 0) {
            throw new IllegalArgumentException("feherjeSzazalek < 0");
        }
        if (feherjeSzazalek > 1) {
            throw new IllegalArgumentException("feherjeSzazalek > 1");
        }
        this.feherjeSzazalek = feherjeSzazalek;
        checkSzazalek();
    }

    /**
     * A zsírtartalom %-ban.
     *
     * @return százalék.
     */
    public double getZsirSzazalek() {
        return zsirSzazalek;
    }

    /**
     * A zsírtartalom %-ban.
     *
     * @param zsirSzazalek a zsírtartalom %-ban.
     */
    public void setZsirSzazalek(double zsirSzazalek) {
        if (Double.isNaN(zsirSzazalek) || Double.isInfinite(zsirSzazalek))
            throw new IllegalArgumentException();
        if (zsirSzazalek < 0) {
            throw new IllegalArgumentException("zsirSzazalek < 0");
        }
        if (zsirSzazalek > 1) {
            throw new IllegalArgumentException("zsirSzazalek < 1");
        }
        this.zsirSzazalek = zsirSzazalek;
        checkSzazalek();
    }

    /**
     * A szénhidrát tartalom %-ban.
     *
     * @return százalék.
     */
    public double getSzenhidratSzazalek() {
        return szenhidratSzazalek;
    }

    /**
     * A szénhidrát tartalom %-ban.
     *
     * @param szenhidratSzazalek a százalék.
     */
    public void setSzenhidratSzazalek(double szenhidratSzazalek) {
        if (Double.isNaN(szenhidratSzazalek) || Double.isInfinite(szenhidratSzazalek))
            throw new IllegalArgumentException();
        if (szenhidratSzazalek < 0) {
            throw new IllegalArgumentException("szenhidratSzazalek < 0");
        }
        if (szenhidratSzazalek > 1) {
            throw new IllegalArgumentException("szenhidratSzazalek > 0");
        }
        this.szenhidratSzazalek = szenhidratSzazalek;
        checkSzazalek();
    }

    /**
     * Az energiatartalom KJ-ban.
     *
     * @return energia KJ.
     */
    public double getEnergiaKJ() {
        return energiaKJ;
    }

    /**
     * Az energiatartalom KJ-ban.
     *
     * @param energiaKJ energia KJ.
     */
    public void setEnergiaKJ(double energiaKJ) {
        if (Double.isNaN(energiaKJ) || Double.isInfinite(energiaKJ))
            throw new IllegalArgumentException();
        if (energiaKJ < 0) {
            throw new IllegalArgumentException("energiaKJ < 0");
        }
        this.energiaKJ = energiaKJ;
    }

    /**
     * Visszaadja a fehérje mennyiségét grammban.
     *
     * @return a mennyiség.
     */
    public double getFeherjeMennyisegGramm() {
        return vonatkoztatasGramm * feherjeSzazalek;
    }

    /**
     * Visszaadja a szénhidrát mennyiségét grammban.
     *
     * @return a mennyiség.
     */
    public double getSzenhidratMennyisegGramm() {
        return vonatkoztatasGramm * szenhidratSzazalek;
    }

    /**
     * Visszaadja a zsír mennyiségét grammban.
     *
     * @return a mennyiség.
     */
    public double getZsirMennyisegGramm() {
        return vonatkoztatasGramm * zsirSzazalek;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AlapanyagJellemzok that = (AlapanyagJellemzok) o;

        if (Double.compare(that.vonatkoztatasGramm, vonatkoztatasGramm) != 0) return false;
        if (Double.compare(that.feherjeSzazalek, feherjeSzazalek) != 0) return false;
        if (Double.compare(that.zsirSzazalek, zsirSzazalek) != 0) return false;
        if (Double.compare(that.szenhidratSzazalek, szenhidratSzazalek) != 0) return false;
        return Double.compare(that.energiaKJ, energiaKJ) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(vonatkoztatasGramm);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(feherjeSzazalek);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(zsirSzazalek);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(szenhidratSzazalek);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(energiaKJ);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
