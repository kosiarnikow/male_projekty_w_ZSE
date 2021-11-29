// poczatek_kodu
#include <iostream>
#include <Windows.h>
#include <string>
#include <time.h>

using namespace std;
int movement_hero, movement_enemy, name_enemy_attack, random_choice_enemy, style_hero_fighter, choice_style_hero_fighter, random_style_enemy_fighter, choice_style_enemy_fighter, win_games;
string random_name_enemy;

// struktura
struct klasa
{
    int AP;
    int AD;
    int MANA;
    int HP;
    int SPEED;
    int RANGE;
    int tornado(){
        cout << "\ntwoj atak: tornado" << endl;
        return AD * 1;
    }
    int ziuf_ziuf(){
        cout << "\ntwoj atak: ziuf_ziuf" << endl;
        return AP * 2;
    }
    int przetupanie(){
        cout << "\ntwoj atak: przetupanie" << endl;
        return SPEED * 4;
    }
    int proba_kryta(){
        cout << "\ntwoj atak:  proba_kryta" << endl;
        return RANGE * 3;
    }
    int leczenie(){
        cout << "\numiejetnosc:  leczenie" << endl;
        return HP * 450;
    }
};
klasa mag = {
300,
100,
200,
2000,
400,
500,
};
klasa zabojca = {
500,
400,
200,
1200,
300,
50,
};
klasa tank = {
200,
600,
100,
2500,
300,
100,   
};
klasa kamikadze = {
900,
900,
100,
500,
500,
50, 
};
klasa diabel = {
400,
600,
300,
2666,
666,
400,   
};
klasa pobozny = {
800,
40,
400,
2137,
450,
600,   
};
klasa wrozbita = {
100,
30,
500,
1200,
20,
300,    
};
klasa kanibal = {
100,
400,
200,
1600,
500,
200,   
};
klasa goniec = {
150,
200,
100,
300,
2000,
400,  
};
klasa elf = {
400,
400,
400,
2000,
200,
200,    
};
klasa hero;
struct opponents{
    int AP;
    int AD;
    int MANA;
    int HP;
    int SPEED;
    int RANGE;
    int tornado(){
        cout << "atak przeciwnika: tornado" << endl;
        return AD * 1;
    }
    int ziuf_ziuf(){
        cout << "atak przeciwnika: ziuf_ziuf" << endl;
        return AP * 2;
    }
    int przetupanie(){
        cout << "atak przeciwnika: przetupanie" << endl;
        return SPEED * 4;
    }
    int proba_kryta(){
        cout << "atak przeciwnika:  proba_kryta" << endl;
        return RANGE * 3;
    }
    int leczenie(){
        cout << "umiejetnosc przeciwnika: leczenie" << endl;
        return HP * 450;
    }
};
opponents jablko_Czesio = {
270,
90,
180,
1500,
360,
450,  
};
opponents cytryna_Slawek = {
450,
360,
280,
1080,
270,
45,
};
opponents jagoda_Basia = {
180,
540,
90,
2250,
270,
90,
};
opponents gruszka_Waldemar = {
810,
810,
90,
450,
450,
45,
};
opponents kiwi_Janina = {
360,
500,
270,
2300,
500,
600,
};
opponents brzoskwinia_Gosia = {
620,
36,
360,
1666,
365,
540,
};
opponents malina_Wiktor = {
90,
27,
450,
1100,
12,
270,    
};
opponents grejfrut_Radek = {
90,
360,
180,
1600,
450,
180,   
};
opponents mandarynka_Ania = {
120,
175,
80,
2600,
170,
300,  
};
opponents pomidor_Czeslaw = {
365,
365,
365,
1800,
180,
180,    
};
opponents enemy;

//maszyny losujace
int random_enemy_attack() {
    name_enemy_attack = rand() % 10 + 1;
    return name_enemy_attack;
}
int random_enemy_attack2() {
    name_enemy_attack = rand() % 5 + 1;
    return name_enemy_attack;
}
string random_enemy() {
        srand(time(NULL));
        random_choice_enemy = random_enemy_attack();
        switch (random_choice_enemy)
        {
            case 1:
                enemy = jablko_Czesio;
                return "jablko_Czesio";
                break;
            case 2:
                enemy = cytryna_Slawek;
                return "cytryna_Slawek";
                break;
            case 3:
                enemy = jagoda_Basia;
                return "jagoda_Basia";
                break;
            case 4:
                enemy = gruszka_Waldemar;
                return "gruszka_Waldemar";
                break;
            case 5:
                enemy = kiwi_Janina;
                return "kiwi_Janina";
                break;
            case 6:
                enemy = brzoskwinia_Gosia;
                return "brzoskwinia_Gosia";
                break;                
            case 7:
                enemy = malina_Wiktor;
                return "malina_Wiktor";
                break;
            case 8:
                enemy = grejfrut_Radek;
                return "grejfrut_Radek";
                break;
            case 9:
                enemy = mandarynka_Ania;
                return "mandarynka_Ania";
                break;
            case 10:
                enemy = pomidor_Czeslaw;
                return "pomidor_Czeslaw;";
                break;

        }
}

//funkcje 
void menu(){
cout << "\n \n WARZYWA FIGHTER - menu\n wybierz opcje 1 - gra, 2 - zasady, 3 - autor\n";
int wybor1 = 0;
cin >> wybor1;
switch (wybor1)
{
    case 1:
        cout << "\nwitamy w wariatkowie\n"; Sleep(1000);
        break;
    case 2:
        cout << "\n tutaj beda zasady\n"; Sleep(1000);
        return menu();
        break;
    case 3:
        cout << "\nautorem tego dziela jest Bartlomiej Zebrowski z klasy 2P\n"; Sleep(1000);
        return menu();
        break;
    default:
        cout << "\n sprobuj jeszcze raz\n";
        return menu();
        break;
}
}
void character_select(){
    int wybor2 = 0;
    Sleep(1000); cout << "wybierz postac: 1-mag, 2-zabojca, 3-tank, 4-kamikadze, 5-diabel, 6-pobozny, 7-wrozbita, 8-kanibal, 9-goniec, 10-elf\n";
    cin >> wybor2;
    switch (wybor2) {
    case 1:
        hero = mag;
        break;
    case 2:
        hero = zabojca;
        break;
    case 3:
        hero = tank;
        break;
    case 4:
        hero = kamikadze;
        break;
    case 5:
        hero = diabel;
        break;
    case 6:
        hero = pobozny;
        break;
    case 7:
        hero = wrozbita;
        break;
    case 8:
        hero = kanibal;
        break;
    case 9:
        hero = goniec;
        break;
    case 10:
        hero = elf;
        break;
    default:
        cout << "\n sprobuj jeszcze raz\n"; Sleep(1000);
        return character_select(); 
        break;
    }
    cout << "wybrales postac nr: " << wybor2 << endl << endl;
}
void hero_movement(){
    cout << "wybierz interakcje: 1 - tornado, 2 - ziuf_ziuf, 3 - przetupanie, 4 - proba_kryta, 5 - leczenie\n";
    cin >> style_hero_fighter;
    switch (style_hero_fighter){
        case 1:
            choice_style_hero_fighter = hero.tornado();
            break;
        case 2:
            choice_style_hero_fighter = hero.ziuf_ziuf();
            break;
        case 3:
            choice_style_hero_fighter = hero.przetupanie();
            break;
        case 4:
            choice_style_hero_fighter = hero.proba_kryta();
            break;        
        case 5:
            choice_style_hero_fighter = hero.leczenie();
            break;
        default:
        cout << "\n sprobuj jeszcze raz\n"; Sleep(1000);
        return hero_movement(); 
        break;
    }
}
void enemy_movement(){
    srand (time(NULL));
    random_style_enemy_fighter = random_enemy_attack2();
    switch (random_style_enemy_fighter){
        case 1:
            choice_style_enemy_fighter = enemy.tornado();
            cout << choice_style_hero_fighter;
            break;
        case 2:
            choice_style_enemy_fighter = enemy.ziuf_ziuf();
            break;
        case 3:
            choice_style_enemy_fighter = enemy.przetupanie();
            break;
        case 4:
            choice_style_enemy_fighter = enemy.proba_kryta();
            break;        
        case 5:
            choice_style_enemy_fighter = enemy.leczenie();
            break;
        default:
        cout << "\n sprobuj jeszcze raz\n"; Sleep(1000);
        return hero_movement(); 
    }
}
void gameplay(){
random_name_enemy = random_enemy();
    cout << "wylosowany przeciwnik: "; Sleep(1000); cout << random_name_enemy << endl;
    do {
        hero_movement();
        enemy.HP -= choice_style_hero_fighter;
        cout << "zadajesz tyle obrazen: " << choice_style_hero_fighter;
        cout << "\n zdrowie przeciwnika:" << enemy.HP << endl << endl; Sleep(1000);
        enemy_movement();
        hero.HP -= choice_style_enemy_fighter;
        cout << "przeciwnik zadaje tobie tyle obrazen: " << choice_style_enemy_fighter << endl;
        cout << "zdrowie gracza: " << hero.HP << endl << endl;  
        if (enemy.HP  <= 0){
            cout << "brawo wygrales, jestes miszczu. Potrzebujemy cie w naszym skladzie";
        }
        if (hero.HP <= 0){
            cout << "HA HA HA, przegrales, sprobuj jeszcze raz kiedys";
        }
        win_games += 1;
        cout << "\nilosc zrobionych ruchow: " << win_games;
    } while (enemy.HP > 0 && hero.HP > 0);
}

//sama gra
int main(){
    menu();
    character_select();
    gameplay();
}