import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Calculadora Flutter',
      theme: ThemeData(
        // This is the theme of your application.
        //
        // TRY THIS: Try running your application with "flutter run". You'll see
        // the application has a purple toolbar. Then, without quitting the app,
        // try changing the seedColor in the colorScheme below to Colors.green
        // and then invoke "hot reload" (save your changes or press the "hot
        // reload" button in a Flutter-supported IDE, or press "r" if you used
        // the command line to start the app).
        //
        // Notice that the counter didn't reset back to zero; the application
        // state is not lost during the reload. To reset the state, use hot
        // restart instead.
        //
        // This works for code too, not just values: Most code changes can be
        // tested with just a hot reload.
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.orangeAccent),
      ),
      home: CalculadoraWidget(),
    );
  }
}

class CalculadoraWidget extends StatefulWidget {
  @override
  State<CalculadoraWidget> createState() {
    return CalculadoraState();
  }
}

class CalculadoraState extends State<CalculadoraWidget> {
  double resultado = 0;
  TextEditingController controller1 = new TextEditingController();
  TextEditingController controller2 = new TextEditingController();
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          spacing: 20.0,
          children: [
            Text(
              "Calculadora UAX",
              style: TextStyle(color: Colors.orange, fontSize: 30.0),
            ),
            Text("Se realizará una suma de operadores"),
            Text("Introduce operandos"),
            Padding(
              padding: const EdgeInsets.only(left: 20, right: 20),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                spacing: 20.0,
                children: [
                  Expanded(
                    child: TextField(
                      controller:controller1,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: "Operando 1",
                      ),
                    ),
                  ),
                  Expanded(
                    child: TextField(
                      controller:controller2,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: "Operando 2",
                      ),
                    ),
                  ),
                ],
              ),
            ),
            ElevatedButton(onPressed: () {
              double op1 = double.parse(controller1.text);
              double op2 = double.parse(controller2.text);
              setState(() {
                resultado = op1+op2;
              });

              ScaffoldMessenger.of(context).showSnackBar(
                SnackBar(
                  content: const Text('Resultado calculado'),
                ),
              );
              controller2.text = "";
              controller1.text = "";
            }, child: Text("Sumar")),
            Text("El resultado de la operacion es $resultado")
          ],
        ),
      ),
    );
  }
}
