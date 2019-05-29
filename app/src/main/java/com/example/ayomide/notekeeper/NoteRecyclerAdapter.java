package com.example.ayomide.notekeeper;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class NoteRecyclerAdapter extends RecyclerView.Adapter<NoteRecyclerAdapter.ViewHolder>{

    private final Context mContext;
    private final List<NoteInfo> mNotes;
    private final LayoutInflater mLayoutInflater;

    public NoteRecyclerAdapter(Context mContext, List<NoteInfo> notes) {
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
        mNotes = notes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.item_note_list, viewGroup, false);
        return new ViewHolder(itemView);
    } //for creating the viewHolder instances

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        NoteInfo note = mNotes.get(position);
        viewHolder.mTextCourse.setText(note.getCourse().getTitle());
        viewHolder.mTextTitle.setText(note.getTitle());
        viewHolder.mCurrentPosition = position;
    }//responsible for associating data with our views

    @Override
    public int getItemCount() {
        return mNotes.size();
    }//indicates the number of data items we have

    public class ViewHolder extends RecyclerView.ViewHolder{

        public final TextView mTextCourse;
        public final TextView mTextTitle;
        public int mCurrentPosition;

        public ViewHolder(@NonNull View itemView) {
            super( itemView );

            mTextCourse = itemView.findViewById(R.id.text_course);
            mTextTitle = itemView.findViewById(R.id.text_title);

            itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, NoteActivity.class);
                    intent.putExtra(NoteActivity.NOTE_POSITION, mCurrentPosition);
                    mContext.startActivity(intent);
                }
            } );
        }


    }
}
