package fr.myapp.mymemory

import android.content.Context
import android.graphics.Canvas
import android.graphics.Point
import android.os.Build
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView

// Cette classe est une ImageView spécialisée dans l'affichage d'une carte à jouer
@RequiresApi(Build.VERSION_CODES.R)
class CarteView(ctxt: Context, carte: Carte) : AppCompatImageView(ctxt) {

    private var ctxt: Context
    public var carte: Carte

    init {
        this.ctxt = ctxt
        this.carte = carte
        // récupérer la ressource correspondant à l'image
        var resId = ctxt.resources.getIdentifier(carte.getNomImage(), "drawable", ctxt.packageName);
        setImageResource(resId)

        //dimensionner le composant
        var widthCarte = ctxt.display!!.width / 7
        var heightCarte = widthCarte * 152/107
        var params = LinearLayout.LayoutParams(widthCarte, heightCarte)
        layoutParams = params
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var resId = ctxt.resources.getIdentifier(carte.getNomImage(), "drawable", ctxt.packageName);
        setImageResource(resId)
       // invalidate()
    }
}
