import type { ComponentType } from 'react';
import { Platform, View } from 'react-native';
import type { NativeProps } from './NativeOverscrollNativeComponent';

type OverscrollViewType = typeof View | ComponentType<NativeProps>;

let OverscrollView: OverscrollViewType = View;

if (Platform.OS === 'android') {
  OverscrollView = require('./NativeOverscrollNativeComponent').default;
}

export default OverscrollView;
