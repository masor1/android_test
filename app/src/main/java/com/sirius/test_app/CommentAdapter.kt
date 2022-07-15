package com.sirius.test_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sirius.test_app.databinding.CommentItemBinding
import com.squareup.picasso.Picasso

class CommentAdapter(
    private val listOfReview: List<ReviewModel>
) : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CommentViewHolder(
        CommentItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )


    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val review = listOfReview[position]
        holder.bind(review)
    }

    override fun getItemCount() = listOfReview.size

    inner class CommentViewHolder(
        private val binding: CommentItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(review: ReviewModel) {
            Picasso.get().load(review.userImage).into(binding.userImage)
            binding.userName.text = review.userName
            binding.date.text = review.date
            binding.review.text = review.message
        }
    }
}