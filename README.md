# react-native-overscroll2

![Supports Android, iOS](https://img.shields.io/badge/platforms-android%20|%20ios-lightgrey.svg?style=flat-square)

A android scrollView decorator for support bounce.

## Explanation

This library is forked from [react-native-overscroll](https://github.com/liuhuman/react-native-overscroll). Because this library has not been updated for a long time, update the library implementation and add event callbacks.

This library support old arch and new arch.

## Installation

```sh
yarn add react-native-overscroll2
```

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
