package no.trainrec.android.framework;

import no.trainrec.core.data.StorageInterface
import no.trainrec.core.data.TrainingRecord

class Storage : StorageInterface {
    override fun load(): TrainingRecord {
        return TrainingRecord(this)
    }
    override fun save(rec: TrainingRecord) {}

}
