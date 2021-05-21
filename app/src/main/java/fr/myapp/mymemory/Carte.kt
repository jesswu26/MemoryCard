package fr.myapp.mymemory

class Carte(valeur: Valeurs, couleur: Couleurs) {
    enum class Valeurs {
        Deux, Trois, Quatre, Cinq, Six, Sept, Huit, Neuf, Dix, Valet, Dame, Roi, As
    }
    enum class Couleurs {
        PIQUE, COEUR, CARREAU, TREFLE
    }
    var valeur: Valeurs? = null
    var couleur: Couleurs? = null
    var visible: Boolean = false

    override fun toString(): String {
        return valeur.toString() + " de " + couleur
    }

    fun getNomImage(): String {
        if (visible) {
            return (couleur.toString() + "_" + valeur.toString()).toLowerCase()
        } else {
            return "dos_bleu"
        }
    }
    init {
        this.couleur = couleur
        this.valeur = valeur
    }
}