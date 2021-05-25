package com.murosar.designpatternsinkotlin.creational

interface ImageReader {
    val decodeImage: DecodedImage
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class GifReader(image: String) : ImageReader {
    override val decodeImage: DecodedImage

    init {
        decodeImage = DecodedImage(image)
    }
}

class JpegReader(image: String) : ImageReader {
    override val decodeImage: DecodedImage

    init {
        decodeImage = DecodedImage(image)
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class DecodedImage(private val image: String) {
    override fun toString(): String {
        return "$image: is decoded"
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class FactoryMethodDemo {

    fun doSomething(image: String) {
        val decodedImage: DecodedImage

        val reader: ImageReader?

        val format = image.substring(image.indexOf('.') + 1, image.length)

        reader = when (format) {
            "gif" -> GifReader(image)
            "jpeg" -> JpegReader(image)
            else -> null
        }

        reader?.let {
            decodedImage = it.decodeImage
            println(decodedImage)
        }
    }
}
