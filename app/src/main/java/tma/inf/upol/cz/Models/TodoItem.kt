package tma.inf.upol.cz.Models

class TodoItem(title: String, content: String) {

    private var mTitle: String = title
    private var mContent: String = content

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

    override fun toString(): String {
        return mTitle;
    }



}