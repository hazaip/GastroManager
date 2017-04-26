package hu.hubasky.gastromanager.entity.bevlist;

import hu.hubasky.gastromanager.entity.alapanyag.Alapanyag;
import hu.hubasky.gastromanager.entity.recept.Hozzavalo;
import hu.hubasky.gastromanager.entity.recept.Recept;

/**
 * A bevásárlólistán egy vásárlandó alapanyagot reprezentál.
 * Created by mirso on 2017. 04. 26..
 */

public final class VasarlandoAlapanyag extends Hozzavalo {
    /**
     * A vásárlási státusz.
     */
    private EVasaroltStatus status;
    /**
     * Az opcionális recept kapcsolat (ha recept miatt került fel.)
     */
    private Recept receptKapcsolat;

    /**
     * Új vásárlandó alapanyag létrehozása.
     *
     * @param mennyiseg a kívánt mennyiség.
     * @param alapanyag az alapanyag.
     */
    public VasarlandoAlapanyag(double mennyiseg, Alapanyag alapanyag) {
        super(mennyiseg, alapanyag);
        setStatus(EVasaroltStatus.BESZERZENDO);
    }


    /**
     * A vásárlási státusz.
     *
     * @return a státuszinfo.
     */
    public EVasaroltStatus getStatus() {
        return status;
    }

    /**
     * Beállítja a sttátuszt.
     *
     * @param status info.
     */
    public void setStatus(EVasaroltStatus status) {
        this.status = status;
    }

    /**
     * Az opcionális recept kapcsolat (ha recept miatt került fel.)
     *
     * @return a recept, ami miatt felkerült a listára, vagy {@code null} ha nem recept miatt kell.
     */
    public Recept getReceptKapcsolat() {
        return receptKapcsolat;
    }

    /**
     * Beállítja a recept kapcsolatot.
     *
     * @param receptKapcsolat a recept, ami miatt felkerült a listára, vagy {@code null} ha nem recept miatt kell.
     */
    public void setReceptKapcsolat(Recept receptKapcsolat) {
        this.receptKapcsolat = receptKapcsolat;
    }
}
