package com.example.listas.data

import com.example.listas.model.Coche

class DataSet {

        /*
        listaCoches.add(Coche("Mondeo",10000,150,"https://cdn.motor1.com/images/mgl/6ZpX4E/s1/2022-ford-mondeo-china-debut.jpg"))
        listaCoches.add(Coche("Focus",20000,100,"https://upload.wikimedia.org/wikipedia/commons/1/19/Ford_Focus_1.0_EcoBoost_Hybrid_ST-Line_%28IV%2C_Facelift%29_%E2%80%93_f_24092022.jpg"))
        listaCoches.add(Coche("Ibiza",20000,100,"https://upload.wikimedia.org/wikipedia/commons/1/19/Ford_Focus_1.0_EcoBoost_Hybrid_ST-Line_%28IV%2C_Facelift%29_%E2%80%93_f_24092022.jpg"))
        listaCoches.add(Coche("Leon",5000,125,"https://upload.wikimedia.org/wikipedia/commons/1/19/Ford_Focus_1.0_EcoBoost_Hybrid_ST-Line_%28IV%2C_Facelift%29_%E2%80%93_f_24092022.jpg"))
        listaCoches.add(Coche("Fiesta",4000,90,"https://upload.wikimedia.org/wikipedia/commons/1/19/Ford_Focus_1.0_EcoBoost_Hybrid_ST-Line_%28IV%2C_Facelift%29_%E2%80%93_f_24092022.jpg"))
        * */

    // metodo que pertenezca a la clase, no al objeto de la clase -> no existen estaticos
    companion object{
        fun getAllModelos(): ArrayList<Coche> {
            val listaCoches = ArrayList<Coche>()
            listaCoches.add(Coche("Mondeo","Ford",10000,150,"https://cdn.motor1.com/images/mgl/6ZpX4E/s1/2022-ford-mondeo-china-debut.jpg"))
            listaCoches.add(Coche("Focus","Ford",20000,100,"https://upload.wikimedia.org/wikipedia/commons/1/19/Ford_Focus_1.0_EcoBoost_Hybrid_ST-Line_%28IV%2C_Facelift%29_%E2%80%93_f_24092022.jpg"))
            listaCoches.add(Coche("Ibiza","Seat",20000,100,"https://upload.wikimedia.org/wikipedia/commons/1/19/Ford_Focus_1.0_EcoBoost_Hybrid_ST-Line_%28IV%2C_Facelift%29_%E2%80%93_f_24092022.jpg"))
            listaCoches.add(Coche("Leon","Seat",5000,125,"https://upload.wikimedia.org/wikipedia/commons/1/19/Ford_Focus_1.0_EcoBoost_Hybrid_ST-Line_%28IV%2C_Facelift%29_%E2%80%93_f_24092022.jpg"))
            listaCoches.add(Coche("Fiesta","Ford",4000,90,"https://upload.wikimedia.org/wikipedia/commons/1/19/Ford_Focus_1.0_EcoBoost_Hybrid_ST-Line_%28IV%2C_Facelift%29_%E2%80%93_f_24092022.jpg"))
            listaCoches.add(Coche("Astra","Opel",4000,90,"https://upload.wikimedia.org/wikipedia/commons/1/19/Ford_Focus_1.0_EcoBoost_Hybrid_ST-Line_%28IV%2C_Facelift%29_%E2%80%93_f_24092022.jpg"))
            listaCoches.add(Coche("Meriva","Opel",4000,90,"https://upload.wikimedia.org/wikipedia/commons/1/19/Ford_Focus_1.0_EcoBoost_Hybrid_ST-Line_%28IV%2C_Facelift%29_%E2%80%93_f_24092022.jpg"))
            return listaCoches
        }
    }

}