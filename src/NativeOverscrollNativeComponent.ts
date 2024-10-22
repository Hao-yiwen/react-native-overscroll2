import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';
import type { ViewProps, HostComponent } from 'react-native';
import type {
  DirectEventHandler,
  Float,
  Int32,
} from 'react-native/Libraries/Types/CodegenTypes';

export type OnOverscrollEvent = Readonly<{
  state: Int32;
  offset: Float;
}>;

export interface NativeProps extends ViewProps {
  bounce: boolean;
  onOverscroll?: DirectEventHandler<OnOverscrollEvent, 'onOverscroll'>;
}

export default codegenNativeComponent<NativeProps>(
  'OverscrollView'
) as HostComponent<NativeProps>;
