package dmitry.mysenko.util_log

import java.lang.Math.min
import javax.inject.Inject

class GearsLogs @Inject constructor() {
    fun logLong(tag: String, text: String, logFunction: (String, String) -> Any, part: Int? = null) {
        val textLength = text.length
        if (textLength > 100_000) {
            val textToPrint = text.substring(0, min(255, text.length))
            val message = "<very long text. L=$textLength> $textToPrint ..."
            logFunction.invoke(tag, message)

            return
        }

        val lineLength = 950
        val textToPrint = text.substring(0, min(lineLength, text.length))
        val message = part?.let { "p$it  $textToPrint" } ?: textToPrint

        logFunction.invoke(tag, message)
        if (textToPrint.length < text.length) {
            val clippedString = text.substring(lineLength)
            logLong(tag, clippedString, logFunction, part?.let { it + 1 } ?: 2)
        }
    }
}