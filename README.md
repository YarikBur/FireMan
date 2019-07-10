# FireMan [![Build Status](https://img.shields.io/badge/Version-20190708-red.svg)](#FireMan)

![FireMan Logo](https://github.com/YarikBur/FireMan/blob/master/img/FireMan.png)
Переделка игры FireMan после LD 39 <img align="left" src="https://github.com/YarikBur/FireMan/blob/master/img/Player.gif">
<br><br><br><br>
<hr>

## Ссылки

###### Скачать [LibGDX](https://libgdx.badlogicgames.com/ci/nightlies/libgdx-nightly-20190628.zip)
###### Скачать [Android Studio](https://developer.android.com/studio)
###### [Wiki](https://github.com/YarikBur/FireMan/wiki)
###### [Виды версий](#версии-проекта)

## Установка проекта

Для начала создаем проект через libgdx (gdx-setup.jar). 

### Указываем основную информацию:
  -  Название проекта "FireMan"
  -  Название каталога "ru.sgs.fireman"
  -  Игровой класс "Main"
  -  В пути (Destination) указываем временный путь для проекта
  -  В Andriod SDK указываем свой путь (у меня это "C:\Users\Yarik\AppData\Local\Android\Sdk")

### Указываем подпроекты:
  -  Desktop
  -  Android

### Указываем расширения:
  -  Box2D (2D физика)
  -  Box2DLights (2D освещение с возможностью добавления лучей)
  -  Freetype (для генерации шрифтов)
  -  Tools (для компактной упаковки изображений (Atlas) и т.д.)
  -  Controllers (поддержка геймпадов для ПК)

![LibGDX Project setup](https://github.com/YarikBur/FireMan/blob/master/img/LibGDX%20Project%20setup.PNG)

После создание проекта во временную папку надо "запулить" проект с GitHub'a. (Пулить надо уже в основную папку проекта). Как вы скачали прокт с GitHub'a надо перенести все файлы из временной папку (куда мы устанавливали проект libgdx) **без замены файлов**.

| **ВАЖНО**: Копировать файлы без замены! |
| --- |

Ещё надо будет воспользоваться [этой статьей](http://developer.alexanderklimov.ru/android/games/libgdx/setup.php) для подключения проекта в Android Studio и настройки IDE, чтобы она умела запускать проект не только для Android'a, но и для ПК.

## Версии проекта
![Build Status Alpha](https://img.shields.io/badge/build-alpha-red.svg)
![Build Status Beta](https://img.shields.io/badge/build-beta-orange.svg)
![Build Status Release](https://img.shields.io/badge/build-release-green.svg)
