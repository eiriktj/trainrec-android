package no.trainrec.android.framework

import no.trainrec.core.data.StorageInterface
import no.trainrec.core.domain.ExerciseEntry
import java.io.File

class Storage(appFilesDir: String) : StorageInterface {

    private val file = File(appFilesDir, "record.csv")

    override fun load(): List<ExerciseEntry> {
        return arrayListOf<ExerciseEntry>()
    }
    override fun save(entries: List<ExerciseEntry>) {}

}
