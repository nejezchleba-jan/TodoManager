package tma.inf.upol.cz.Models

class TodoItem(title: String, content: String, finished: Boolean) {

    private var mTitle: String = title
    private var mContent: String = content
    private var mFinished: Boolean = finished;

    fun getTitle(): String {
        return mTitle
    }

    fun setTitle(title: String) {
        mTitle = title
    }

    fun getContent(): String {
        return mContent
    }

    fun setContent(content: String) {
        mContent = content
    }

    fun getFinished(): Boolean {
        return mFinished
    }

    fun setFinished(finished: Boolean) {
        mFinished = finished
    }

    override fun toString(): String {
        return mTitle;
    }



}