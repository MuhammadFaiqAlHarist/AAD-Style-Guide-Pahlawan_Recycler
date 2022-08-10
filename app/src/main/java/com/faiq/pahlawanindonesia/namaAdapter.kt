package com.faiq.pahlawanindonesia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.faiq.pahlawanindonesia.data.DaftarPahlawanItem
import com.faiq.pahlawanindonesia.databinding.NamaListPahlawanBinding

class namaAdapter(private var pahlawanlist: List<DaftarPahlawanItem>) : RecyclerView.Adapter<namaAdapter.PahlawanViewHolder>(){

    inner class PahlawanViewHolder(val binding: NamaListPahlawanBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PahlawanViewHolder = PahlawanViewHolder(
        NamaListPahlawanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: PahlawanViewHolder, position: Int) {
        val pahlawannama = pahlawanlist[position]
        holder.binding.apply {
            tvNamaLengkap.text = pahlawannama.asal
            tvKategori.text = pahlawannama.kategori

            Glide.with(imagePahlawan)
                .load(pahlawannama.img)
                .into(imagePahlawan)
        }
    }

    override fun getItemCount(): Int {
        return pahlawanlist.size
    }
}