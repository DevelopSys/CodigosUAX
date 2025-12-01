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
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
      ),
      home: CalculadoraStateFull(),
    );
  }
}

class CalculadoraStateFull extends StatefulWidget {
  @override
  State<StatefulWidget> createState() {
    return CalculadoraState();
  }
}

class CalculadoraState extends State<CalculadoraStateFull> {

  double resultado = 10.0;
  TextEditingController controllerOP1 = TextEditingController();
  TextEditingController controllerOP2 = TextEditingController();
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return Scaffold(
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text("Caculadora UAX"),
            Padding(padding: EdgeInsets.all(12.0)),
            Text("Introduce los operadores a calcular"),
            Container(
              padding: EdgeInsets.all(24.0),
              child: Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Expanded(
                    child: TextField(
                      controller: controllerOP1,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Operando 1',
                      ),
                    ),
                  ),
                  Expanded(
                    child: TextField(
                      controller: controllerOP2,
                      decoration: InputDecoration(
                        border: OutlineInputBorder(),
                        labelText: 'Operando 2',
                      ),
                    ),
                  ),
                ],
              ),
            ),
            ElevatedButton(onPressed: (){
              setState(() {
                double op1 = double.parse(controllerOP1.text);
                double op2 = double.parse(controllerOP2.text);
                resultado = op2+op1;
                controllerOP1.text = "";
                controllerOP2.text = "";
              });
            }, child: Text("Sumar")),
            Padding(padding: EdgeInsets.all(12.0)),
            Text("El resultado es: $resultado")
          ],
        ),
      ),
    );
  }
}
