package fr.myapp.mymemory

import java.util.ArrayList

class Jeu52 : ArrayList<Carte?>() {
    private val aleaIterator: AleaIterator? = null
    fun aleaIterator(): AleaIterator {
        return AleaIterator()
    }
    inner class AleaIterator {
        operator fun next(): Carte? {
            val n = (Math.random() * this@Jeu52.size).toInt()
            val carte = get(n)
            removeAt(n)
            return carte
        }
        operator fun hasNext(): Boolean {
            return this@Jeu52.size > 0
        }
    }
    init {
        for (valCarte in Carte.Valeurs.values()) {
            for (coulCarte in Carte.Couleurs.values()) {
                add(Carte(valCarte, coulCarte))
            }
        }
    }
}