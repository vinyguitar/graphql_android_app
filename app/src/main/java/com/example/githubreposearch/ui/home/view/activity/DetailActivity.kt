package com.example.githubreposearch.ui.home.view.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.githubreposearch.R
import com.example.githubreposearch.domain.model.GitHubRepositoryModel
import com.example.githubreposearch.ui.home.view.fragment.DetailFragment
import kotlinx.android.synthetic.main.activity_item_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(detail_toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            val fragment = DetailFragment().apply {
                arguments = Bundle().apply {
                    putParcelable(
                        DetailFragment.ARG_ITEM,
                        intent.getParcelableExtra<GitHubRepositoryModel>(DetailFragment.ARG_ITEM)
                    )
                }
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.item_detail_container, fragment)
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {

                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}
