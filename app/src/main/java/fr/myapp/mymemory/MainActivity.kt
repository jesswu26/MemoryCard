package fr.myapp.mymemory

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.annotation.RequiresApi

var tapis: ArrayList<CarteView> = ArrayList<CarteView>()
var cartesVisibles: ArrayList<CarteView> = ArrayList<CarteView>()

class MainActivity : AppCompatActivity() {
    private lateinit var gdMemory: GridLayout

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gdMemory = findViewById(R.id.gdMemory)
//        var tapis: ArrayList<CarteView> = ArrayList<CarteView>()
//        var cartesVisibles: ArrayList<CarteView> = ArrayList<CarteView>()

        var jeu: Jeu52 = Jeu52();
        var it = jeu.aleaIterator()
        while (it.hasNext()) {
            var carte = it.next() as Carte
            var ivCarte: CarteView = CarteView(this, carte)
            // gdMemory.addView(ivCarte)
            tapis.add(ivCarte)

            ivCarte.setOnClickListener(View.OnClickListener {
                ivCarte.carte.visible = true;
                cartesVisibles.add(ivCarte)
                //ivCarte.invalidate()
                if (cartesVisibles.size == 3) {
                    var carte1 = cartesVisibles.get(0).carte
                    var carte2 = cartesVisibles.get(1).carte
                    if (carte1.valeur == carte2.valeur) {
                    } else {
                        carte1.visible = false
                        cartesVisibles.get(0).invalidate()
                        carte2.visible = false
                        cartesVisibles.get(1).invalidate()
                    }
                    cartesVisibles.removeAt(1)
                    cartesVisibles.removeAt(0)
                }

            })
        }

        // insérer toutes ces CarteView dans le GeidView
        for (view in tapis) {
            gdMemory.addView(view);
        }
        }
    }

