package muh.mobi.tasch.model

object Store {

    init {
        println("Singleton class invoked.")
    }

    var wishlist = mutableSetOf<Product>()
    var rates = mapOf<Product, Int>()

    /*
        Data generator
     */
    val products = arrayOf (
        Product(
            "Carrier",
            "https://i.postimg.cc/d3f7mgTS/bag-1.jpg",
            "David Jones PU Structured Flapover Shoulder Bag Orange",
            arrayOf( AvailableColor(255, 0,3 )),
            Size(2,2,2),
            84.00,
            3)

        ,
        Product(
            "Travol",
            "https://herschel.ca/content/dam/herschel/products/10631/10631-02469-OS_01.jpg.sthumbnails.1000.1250.jpg",
            "Bugatti Contratempo Duffel Bag on Wheels Black",
            arrayOf( AvailableColor(255, 240,3 ) , AvailableColor(33, 15, 34 ) ),
            Size(2,20,2),
            24.09,
            3)

        ,
        Product(
            "Ubranito",
            "https://i.postimg.cc/qqHBJ0yr/bag-3.jpg",
            "Matt and Nat Brave Backpack Dwell Collection Black",
            arrayOf( ),
            Size(5,5,2),
            2.50,
            3)

        ,
        Product(
            "Brave Backpack",
            "https://i.postimg.cc/JhtzKpMf/bag-4.jpg",
            "Matt and Nat Brave Backpack Loom Collection Desert",
            arrayOf( AvailableColor(12, 250,3 ) , AvailableColor(141, 255, 13 ), AvailableColor(11, 25, 183 )  ),
            Size(2,2,2),
            224.05,
            3)
        ,
        Product(
            "Navy",
            "https://i.postimg.cc/W1FynZx9/bag-5.jpg",
            "Navy blue and brown ",
            arrayOf( AvailableColor(25, 60,32 ) , AvailableColor(210, 15, 231 ) ) ,
            Size(23,12,28),
            34.99,
            3)
    )
}
