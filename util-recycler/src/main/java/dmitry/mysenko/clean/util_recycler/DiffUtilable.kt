package dmitry.mysenko.clean.util_recycler

interface DiffUtilable<T> {
    fun areItemsTheSame(other: DiffUtilable<T>): Boolean
    fun areContentsTheSame(other: DiffUtilable<T>): Boolean
}