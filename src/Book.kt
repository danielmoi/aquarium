open class Book(val title: String, val author: String) {

    private var currentPage: Int = 1

    open fun readPage() {
        currentPage += 1

    }
}

class eBook(title: String, author: String, var format: String = "text"): Book(title, author) {

    private var wordCount: Int = 1

    override fun readPage() {
       wordCount += 250
    }
}