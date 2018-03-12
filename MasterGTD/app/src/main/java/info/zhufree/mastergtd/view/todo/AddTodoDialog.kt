package info.zhufree.mastergtd.view.todo

import android.app.AlertDialog
import android.app.Dialog
import android.app.DialogFragment
import android.os.Bundle
import info.zhufree.mastergtd.R

/**
 * Created by zhufree on 2018/3/12.
 * 添加todo的DialogFragment
 */

class AddTodoDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(context)
        // Get the layout inflater
        val inflater = activity.layoutInflater
        val view = inflater.inflate(R.layout.dialog_add_task, null)
//        mUsername = (EditText) view.findViewById(R.id.id_txt_username)
//        mPassword = (EditText) view.findViewById(R.id.id_txt_password)
        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(view)
                // Add action buttons
                .setPositiveButton(R.string.sure,  {_, _ ->

                })
        return builder.create()
    }
}
