package com.example.basiccase

import android.Manifest
import android.app.Activity
import android.app.SearchManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.Menu
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.basiccase.Status.*
import com.example.basiccase.api.model.categories.Category
import com.example.basiccase.api.model.collections.Collection
import com.example.basiccase.api.model.featured.Featured
import com.example.basiccase.api.model.products.Products
import com.example.basiccase.api.model.shop.Shop
import com.example.basiccase.databinding.ActivityMainBinding
import com.example.basiccase.ui.category.adapter.CategoryAdapter
import com.example.basiccase.ui.collection.adapter.CollectionAdapter
import com.example.basiccase.ui.product.adapter.ProductAdapter
import com.example.basiccase.ui.shops.ShopEditorAdapter
import com.example.basiccase.ui.shops.ShopNewAdapter
import com.example.basiccase.util.adapter.TabSliderAdapter
import com.example.basiccase.viewmodel.CaseViewModel
import com.github.ajalt.timberkt.e
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.ObsoleteCoroutinesApi


@ObsoleteCoroutinesApi
@FlowPreview
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val RecordAudioRequestCode = 1

    lateinit var binding: ActivityMainBinding

    lateinit var searchView: SearchView

    private val productList = arrayListOf<Products>()
    private val categoryList = arrayListOf<Category>()
    private val collectionList = arrayListOf<Collection>()
    private val shopEditorList = arrayListOf<Shop>()
    private val featuredList = arrayListOf<Featured>()
    private val shopNewList = arrayListOf<Shop>()
    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var productAdapter: ProductAdapter
    private lateinit var collectionAdapter: CollectionAdapter
    private lateinit var shopEditorAdapter: ShopEditorAdapter
    private lateinit var shopNewAdapter: ShopNewAdapter


    private val caseViewModel: CaseViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding =
            DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)


        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.RECORD_AUDIO
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            checkPermission()
        }




        caseViewModel.getCaseDatas().observe(this, Observer {
            when (it.status) {
                SUCCESS -> {
                    featuredList.addAll(it!!.data!![0].featured!!)
                    productList.addAll(it.data!![1].products!!)
                    collectionList.addAll(it.data[3].collections!!)
                    shopEditorList.addAll(it.data[4].shops!!)
                    shopNewList.addAll(it.data[5].shops!!)
                    categoryList.addAll(it.data[2].categories!!).apply {
                        productAdapter = ProductAdapter(productList)
                        categoryAdapter = CategoryAdapter(categoryList)
                        collectionAdapter = CollectionAdapter(collectionList)
                        shopEditorAdapter = ShopEditorAdapter(shopEditorList)
                        shopNewAdapter = ShopNewAdapter(shopNewList)
                        binding.vpSliderFeatures.adapter = TabSliderAdapter(featuredList).apply {
                            setupDots()
                            setCurrentDots(0)
                        }

                        binding.rvProducts.adapter = productAdapter
                        binding.rvCategory.adapter = categoryAdapter
                        binding.rvCollection.adapter = collectionAdapter
                        binding.rvShopsNew.adapter = shopNewAdapter
                        binding.rvShopsEditor.adapter = shopEditorAdapter.apply {
                            binding.datashopeditor = shopEditorList[0]
                        }


                    }


                }
                ERROR -> {

                }
                LOADING -> {

                }
            }
        })


        binding.vpSliderFeatures.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentDots(position)
            }
        })

        binding.rvShopsEditor.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val position: Int =
                        (binding.rvShopsEditor.getLayoutManager() as LinearLayoutManager)
                            .findFirstVisibleItemPosition()
                    binding.datashopeditor = shopEditorList[position]
                    e { "position : " + position.toString() }

                }
            }
        })


    }

    private fun setupDots() {
        val dots = arrayOfNulls<ImageView>(featuredList.size)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(8, 0, 8, 0)
        for (i in dots.indices) {
            dots[i] = ImageView(applicationContext)
            dots[i].apply {
                this?.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.dot_inactive
                    )
                )
                this?.layoutParams = layoutParams
            }
            binding.llDotContainer.addView(dots[i])
        }
    }

    private fun setCurrentDots(index: Int) {
        val childCount = binding.llDotContainer.childCount
        for (i in 0 until childCount) {
            val imageView = binding.llDotContainer.get(i) as ImageView

            if (i == index) {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.dot_active
                    )
                )
            } else {
                imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.dot_inactive
                    )
                )
            }
        }


    }

    private fun checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.RECORD_AUDIO),
                RecordAudioRequestCode
            )
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the options menu from XML
        val inflater = menuInflater
        inflater.inflate(R.menu.search_view, menu)


        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView =(menu.findItem(R.id.search).actionView as SearchView).apply {
            // Assumes current activity is the searchable activity
            setSearchableInfo(searchManager.getSearchableInfo(componentName))
            setIconifiedByDefault(false)
            // Do not iconify the widget; expand it by default
        }

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {

                //display text where ever i want
                return false
            }

            override fun onQueryTextChange(query: String?): Boolean {
                //display text where ever i want

                return false
            }
        })


        return true
    }


    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        if (Intent.ACTION_SEARCH == intent.action) {
            val query = intent.getStringExtra(SearchManager.QUERY)
            e { query.toString() }
            searchView.setQuery(query, false)
        }
    }


}

