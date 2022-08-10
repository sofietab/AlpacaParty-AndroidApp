package com.example.sofietb_oblig2

import android.util.Log
import android.util.Log.DEBUG
import com.example.sofietb_oblig2.BuildConfig.DEBUG
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.coroutines.awaitString

import com.google.gson.Gson
import de.hdodenhof.circleimageview.BuildConfig.DEBUG
import java.lang.Exception




class DataSource {

    private val partiListe = mutableListOf<AlpacaParty>()
    private val stemmer1 = mutableListOf<Stemmer>()
    private val stemmer2 = mutableListOf<Stemmer>()
    private val stemmer3 = mutableListOf<Stemmer>()
    suspend fun callApi(): List<AlpacaParty> {

        try {
            val listeObjekt = Gson().fromJson(
                Fuel.get("https://www.uio.no/studier/emner/matnat/ifi/IN2000/v22/obligatoriske-oppgaver/alpacaparties.json")
                    .awaitString(), AlpacaParties::class.java
            )


            for (objekt in listeObjekt.parties!!) {
                partiListe.add(objekt)
            }

        } catch (e: Exception) {
            Log.d("fetch", e.toString())
        }
        return partiListe


    }

    suspend fun callApiStemmer(pos: Int): List<AlpacaParty> {
        //skjønner denne kunne vært gjort mer effektiv. mye lik kode, men titt på første  og siste if, ingenting funker uansett

        try {
            if (pos == 0) {
                val stemme = Gson().fromJson(
                    Fuel.get("https://www.uio.no/studier/emner/matnat/ifi/IN2000/v22/obligatoriske-oppgaver/dis trict1.json")
                        .awaitString(), Stemmer::class.java

                )
                stemmer1.add(stemme)

                for (verdi in stemmer1) {
                    if (verdi.id == 1) {
                        partiListe[0].settStemmer()

                    }
                    if (verdi.id == 2) {
                        partiListe[1].settStemmer()

                    }
                    if (verdi.id == 3) {
                        partiListe[2].settStemmer()

                    }
                    if (verdi.id == 4) {
                        partiListe[3].settStemmer()

                    }

                }
                var prosent1 = (partiListe[0].hentStemmer().toDouble() /stemmer1.size) * 100
                partiListe[0].settProsent(prosent1)
                var prosent2 = (partiListe[1].hentStemmer().toDouble() /stemmer1.size) * 100
                partiListe[1].settProsent(prosent2)
                var prosent3 = (partiListe[2].hentStemmer().toDouble() /stemmer1.size) * 100
                partiListe[2].settProsent(prosent3)
                var prosent4 = (partiListe[3].hentStemmer().toDouble() /stemmer1.size) * 100
                partiListe[3].settProsent(prosent4)
            }

            if (pos == 1) {
                val stemme = Gson().fromJson(
                    Fuel.get("https://www.uio.no/studier/emner/matnat/ifi/IN2000/v22/obligatoriske-oppgaver/dis trict2.json")
                        .awaitString(), Stemmer::class.java

                )
                stemmer2.add(stemme)

                for (verdi in stemmer2) {
                    if (verdi.id == 1) {
                        partiListe[0].settStemmer()

                    }
                    if (verdi.id == 2) {
                        partiListe[1].settStemmer()

                    }
                    if (verdi.id == 3) {
                        partiListe[2].settStemmer()

                    }
                    if (verdi.id == 4) {
                        partiListe[3].settStemmer()

                    }

                }
                var prosent1 = (partiListe[0].hentStemmer().toDouble() /stemmer2.size) * 100
                partiListe[0].settProsent(prosent1)
                var prosent2 = (partiListe[1].hentStemmer().toDouble() /stemmer2.size) * 100
                partiListe[1].settProsent(prosent2)
                var prosent3 = (partiListe[2].hentStemmer().toDouble() /stemmer2.size) * 100
                partiListe[2].settProsent(prosent3)
                var prosent4 = (partiListe[3].hentStemmer().toDouble() /stemmer2.size) * 100
                partiListe[3].settProsent(prosent4)
            }
            if (pos==2){

            }

        }

        catch (e: Exception) {
            Log.d("fetch", e.toString())
        }
        return partiListe


    }
}
