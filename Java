import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'To-Do List',
      home: TodoList(),
    );
  }
}

class TodoList extends StatefulWidget {
  @override
  _TodoListState createState() => _TodoListState();
}

class _TodoListState extends State<TodoList> {
  final _todoController = TextEditingController();
  List<String> _todoList = [];

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.teal.shade100,
      appBar: AppBar(
        shadowColor: Colors.amber,
        backgroundColor: Colors.teal.shade200,
        title: Text("To-Do List"),
      ),
      body: Column(
        children: <Widget>[
          Container(
            padding: EdgeInsets.all(10.0),
            child: TextField(
              controller: _todoController,
              decoration: InputDecoration(
                hintText: "Add a task",
              ),
            ),
          ),
          Expanded(
            child: ListView.builder(
              itemCount: _todoList.length,
              itemBuilder: (BuildContext context, int index) {
                return ListTile(
                  title: Text(_todoList[index]),
                  onTap: () {
                    setState(() {
                      _todoList.removeAt(index);
                    });
                  },
                );
              },
            ),
          ),
        ],
      ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: Colors.teal.shade900,
        onPressed: () {
          setState(() {
            _todoList.add(_todoController.text);
            _todoController.clear();
          });
        },
        child: Icon(Icons.add),
      ),
    );
  }
}
