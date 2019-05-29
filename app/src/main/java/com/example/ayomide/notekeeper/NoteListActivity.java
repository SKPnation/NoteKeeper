package com.example.ayomide.notekeeper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    //private ArrayAdapter<NoteInfo> mAdapterNotes;
    List<NoteInfo> notes;
    private NoteRecyclerAdapter mNoteRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_note_list );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();
            }
        });

        InitializeContent();
    }

    @Override
    protected void onResume(){
        super.onResume();
        mNoteRecyclerAdapter.notifyDataSetChanged();
    }

    private void InitializeContent()
    {
        final RecyclerView recycler_notes = (RecyclerView) findViewById(R.id.list_notes);
        final LinearLayoutManager notesLayoutManager = new LinearLayoutManager(this);
        recycler_notes.setLayoutManager(notesLayoutManager);

        notes = DataManager.getInstance().getNotes();
        mNoteRecyclerAdapter = new NoteRecyclerAdapter(this, notes);
        recycler_notes.setAdapter( mNoteRecyclerAdapter );
    }

}
