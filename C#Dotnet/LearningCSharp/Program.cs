// See https://aka.ms/new-console-template for more information
using a;

public class Computer
{
    public string Motherboard { get; set; } = "";
    public int CPUCores { get; set; }
    public bool hasWifi { get; set; }
    public bool hasLTE { get; set; }
    public DateTime ReleaseDate { get; set; }
    public decimal Price { get; set; }
    public string VideoCard { get; set; } = "";
}
internal class Program
{
    static void Main(string[] args)
    {
        Computer myComputer = new Computer();
        myComputer.Motherboard = "ASUS ROG STRIX B550-F GAMING";
        myComputer.CPUCores = 8;
        myComputer.hasWifi = true;
        myComputer.hasLTE = false;
        myComputer.ReleaseDate = new DateTime(2020, 6, 16);
        myComputer.Price = 199.99M;
        myComputer.VideoCard = "NVIDIA GeForce RTX 3080";

        Console.WriteLine($"Motherboard: {myComputer.Motherboard}");
        Console.WriteLine($"CPU Cores: {myComputer.CPUCores}");
        Console.WriteLine($"Has WiFi: {myComputer.hasWifi}");
        Console.WriteLine($"Has LTE: {myComputer.hasLTE}");
        Console.WriteLine($"Release Date: {myComputer.ReleaseDate.ToShortDateString()}");
        Console.WriteLine($"Price: ${myComputer.Price}");
        Console.WriteLine($"Video Card: {myComputer.VideoCard}");
    }   
}