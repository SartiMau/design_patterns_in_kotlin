package com.murosar.designpatternsinkotlin.structural

// Define a "lowest common denominator"
interface AbstractFile {
    fun ls()
}

//-----------------------------------------------------------------------------------------------------------------------------------------

// File implements the "lowest common denominator"
class File(private val name: String) : AbstractFile {

    override fun ls() {
        println(CompositeClient.compositeBuilder.toString() + name)
    }
}

// Directory implements the "lowest common denominator"
class Directory(private val name: String) : AbstractFile {
    private val includedFiles: ArrayList<AbstractFile> = ArrayList()
    fun add(abstractFile: AbstractFile) {
        includedFiles.add(abstractFile)
    }

    override fun ls() {
        println(CompositeClient.compositeBuilder.toString() + name)
        CompositeClient.compositeBuilder.append("   ")
        for (includedFile in includedFiles) {
            // Leverage the "lowest common denominator"
            val obj = includedFile as AbstractFile
            obj.ls()
        }
        CompositeClient.compositeBuilder.setLength(CompositeClient.compositeBuilder.length - 3)
    }
}

//-----------------------------------------------------------------------------------------------------------------------------------------

class CompositeClient {

    fun doSomething() {
        val music = Directory("MUSIC")
        val scorpions = Directory("SCORPIONS")
        val dio = Directory("DIO")

        val track1 = File("Don't wary, be happy.mp3")
        val track2 = File("track2.m3u")
        val track3 = File("Wind of change.mp3")
        val track4 = File("Big city night.mp3")
        val track5 = File("Rainbow in the dark.mp3")

        music.add(track1)
        music.add(scorpions)
        music.add(track2)

        scorpions.add(track3)
        scorpions.add(track4)
        scorpions.add(dio)

        dio.add(track5)

        music.ls()
    }

    companion object {
        var compositeBuilder = StringBuffer()
    }
}
