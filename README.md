# react-native-overscroll2

![Supports Android, iOS](https://img.shields.io/badge/platforms-android%20|%20ios-lightgrey.svg?style=flat-square)

A android scrollView decorator for support bounce.

## Explanation

This library is forked from [react-native-overscroll](https://github.com/liuhuman/react-native-overscroll). Because this library has not been updated for a long time, update the library implementation and add event callbacks.

This library support old arch and new arch.

本库主要用于 Android ScrollView / FlatList 的回弹（overscroll bounce）装饰；iOS 上会回退为普通 `View`。当前开发与 example 工程基于 **React Native 0.88.1**，Android 默认 `minSdk 24`、`compileSdk 37`。

## Compatibility

| Item | Version |
| --- | --- |
| React Native (example / verified) | 0.88.1 |
| React | 19.3.0 |
| Android minSdk | 24 |
| Android compileSdk | 37 |
| New Architecture (Fabric) | Supported (`src/newarch` + codegen) |
| Old Architecture | Still shipped (`src/oldarch`) for hosts that keep it enabled |

Recommended host toolchain for current RN: JDK 17+, Gradle 9.4.x, Kotlin 2.2.x, AGP provided by the app / React Native template.

> Note: TypeScript codegen specs now import public APIs (`codegenNativeComponent` / `CodegenTypes`) from `react-native` (Strict TypeScript API). Typechecking against RN &lt; 0.80 may require adjusting those imports.

## Installation

```sh
yarn add react-native-overscroll2
```

或使用 npm：

```sh
npm install react-native-overscroll2
```

Autolinking 会处理 Android 原生模块；重新构建原生应用即可。

## Usage

```js
import { FlatList } from 'react-native';
import { OverscrollView } from 'react-native-overscroll2';

const data = Array.from({ length: 20 }, (_, i) => `Item ${i + 1}`);

<OverscrollView
  bounce={true}
  onOverscroll={(event) => {
    console.log(
      'onOverscroll',
      event.nativeEvent.state,
      event.nativeEvent.offset
    );
  }}
>
  <FlatList
    data={data}
    keyExtractor={(_item, index) => index.toString()}
    renderItem={renderItem}
    overScrollMode="always"
  />
</OverscrollView>;
```

## License

MIT
