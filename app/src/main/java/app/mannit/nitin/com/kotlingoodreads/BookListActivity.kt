package app.mannit.nitin.com.kotlingoodreads


import ServiceGenerator
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import models.Output
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * An activity representing a list of Books. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [BookDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class BookListActivity : AppCompatActivity() {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var mTwoPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_list)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.title = title

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val recyclerView = findViewById(R.id.book_list)!!
        setupRecyclerView(recyclerView as RecyclerView)

        if (findViewById(R.id.book_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true
        }
    }


    private fun setupRecyclerView(recyclerView: RecyclerView) {
        val mResponse = ServiceGenerator.endPointInterface.getBooks()
        mResponse.enqueue(object : Callback<Output> {
            override fun onResponse(call: Call<Output>, response: Response<Output>) {
                val books = response.body().books!!
                val titles = mutableListOf(books._112618928!!.title,
                        books._118889679!!.title, books._118889688!!.title,
                        books._124471069!!.title, books._131387846!!.title,
                        books._30966619!!.title, books._3589685!!.title,
                        books._39285978!!.title, books._41601804!!.title, books._79141967!!.title)
                val images = mutableListOf(books._112618928!!.cover,
                        books._118889679!!.cover, books._118889688!!.cover,
                        books._124471069!!.cover, books._131387846!!.cover,
                        books._30966619!!.cover, books._3589685!!.cover,
                        books._39285978!!.cover, books._41601804!!.cover, books._79141967!!.cover)

                recyclerView.adapter = SimpleItemRecyclerViewAdapter(titles, images)
            }

            override fun onFailure(call: Call<Output>, t: Throwable) {

            }
        })
    }

    inner class SimpleItemRecyclerViewAdapter(private val mTitles: MutableList<String?>, private val mImages: MutableList<String?>) : RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.cards, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val title = mTitles[position]
            val image = mImages[position]

            if (title != null && image != null) {
                holder.setItem(title, image)
            }

            holder.mView.setOnClickListener { v ->
                if (mTwoPane) {
                    val arguments = Bundle()
                    arguments.putString(BookDetailFragment.ARG_ITEM_ID, holder.mTitle.text.toString())
                    val fragment = BookDetailFragment()
                    fragment.arguments = arguments
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.book_detail_container, fragment)
                            .commit()
                } else {
                    val context = v.context
                    val intent = Intent(context, BookDetailActivity::class.java)
                    intent.putExtra(BookDetailFragment.ARG_ITEM_ID, holder.mTitle.text.toString())

                    context.startActivity(intent)
                }
            }
        }

        override fun getItemCount(): Int {
            return mTitles.size
        }

        inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
            val mImage: ImageView = mView.findViewById(R.id.img) as ImageView
            val mTitle: TextView = mView.findViewById(R.id.name) as TextView

            fun setItem(book: String, mImageURL: String) {
                mTitle.text = book
                Glide.with(applicationContext).load(mImageURL).into(mImage)
            }
        }
    }
}
