package com.example.sofietb_oblig2



data class AlpacaParties(val parties: List<AlpacaParty>?)

data class AlpacaParty(val id: String?, val name: String?, val leader: String?, val img: String?, val color: String?) {
    fun hentStemmer():Int {
        return stemmer
            //.toString() + prosent.toString()

    }

    fun settStemmer() {
        stemmer ++
    }
    fun settProsent(p: Double){
        prosent=p

    }
}

var stemmer = 0
var prosent = 0.0


